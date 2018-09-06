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

public class Step1 {
	public static class myMapper extends Mapper<Object, Text, IntWritable, Text> {
		private final static IntWritable k = new IntWritable();
		private final static Text v = new Text();

		@Override
		protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String[] tokens = Recommend.DELIMITER.split(value.toString());
			int userID = Integer.parseInt(tokens[0]);
			String itemID = tokens[1];
			String pref = tokens[2];
			k.set(userID);
			v.set(itemID + ":" + pref);
			context.write(k, v);
		}
	}

	public static class myReducer extends Reducer<IntWritable, Text, IntWritable, Text> {
		private final static Text v = new Text();

		@Override
		protected void reduce(IntWritable k2, Iterable<Text> v2s, Context context)
				throws IOException, InterruptedException {
			StringBuilder sb = new StringBuilder();
			for (Text v2 : v2s) {
				sb.append("," + v2.toString());
			}
			v.set(sb.toString().replaceFirst(",", ""));
			context.write(k2, v);
		}
	}

	public static void runStep1(Map<String, String> path)
			throws IOException, URISyntaxException, ClassNotFoundException, InterruptedException {
		String input = path.get("Step1Input");
		String output = path.get("Step1Output");

		Configuration conf = new Configuration();
		FSDao fsDao = new FSDao(input, conf, Step1.class.getSimpleName());
		Job job = fsDao.conf();

		job.setJarByClass(Step1.class);
		FileInputFormat.addInputPath(job, new Path(input));
		job.setInputFormatClass(TextInputFormat.class);
		job.setMapperClass(myMapper.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setCombinerClass(myReducer.class);
		job.setReducerClass(myReducer.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);
		FileOutputFormat.setOutputPath(job, new Path(output));
		job.setOutputFormatClass(TextOutputFormat.class);
		fsDao.rmr(output);
		job.waitForCompletion(true);
	}
}