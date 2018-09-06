package ItemRecom2;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Step2 {
	public static class myMapper extends Mapper<Object, Text, Text, IntWritable> {
		private final static Text k = new Text();
		private final static IntWritable v = new IntWritable(1);

		@Override
		protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

			String[] tokens = Recommend.DELIMITER.split(value.toString());
			for (int i = 1; i < tokens.length; i++) {
				String itemID = tokens[i].split(":")[0];// itemID 101
				for (int j = 1; j < tokens.length; j++) {
					String itemID2 = tokens[j].split(":")[0]; // 101
					k.set(itemID + ":" + itemID2);
					context.write(k, v);
				}
			}
		}
	}

	public static class myReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		private final static IntWritable v = new IntWritable();

		@Override
		protected void reduce(Text k2, Iterable<IntWritable> v2s, Context context)
				throws IOException, InterruptedException {
			int count = 0;
			for (IntWritable v2 : v2s) {
				count += v2.get();
			}
			v.set(count);
			context.write(k2, v);
		}
	}

	public static void runStep2(Map<String, String> path)
			throws IOException, URISyntaxException, ClassNotFoundException, InterruptedException {
		String input = path.get("Step2Input");
		String output = path.get("Step2Output");

		Configuration conf = new Configuration();
		FSDao fsDao = new FSDao(input, conf, Step2.class.getSimpleName());
		Job job = fsDao.conf();
 
		job.setJarByClass(Step2.class);
		FileInputFormat.addInputPath(job, new Path(input));
		job.setInputFormatClass(TextInputFormat.class);

		job.setMapperClass(myMapper.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
 

		job.setCombinerClass(myReducer.class);

		job.setReducerClass(myReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		FileOutputFormat.setOutputPath(job, new Path(output));
		job.setOutputFormatClass(TextOutputFormat.class);
		fsDao.rmr(output);
		job.waitForCompletion(true);
	}
}