package ItemRecom2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;


public class FSDao {

	private static final String HDFS = "file:///d:/bigdata/hadoop/test/";

	private String hdfsPath;

	private Configuration conf;
 
	private String name;

	public FSDao(Configuration conf) {
		this.conf = conf;
	}

	public FSDao(Configuration conf, String name) {
		this.conf = conf;
		this.name = name;
	}

	public FSDao(String hdfs, Configuration conf, String name) {
		this.hdfsPath = hdfs;
		this.conf = conf;
		this.name = name;
	}

	public Job conf() throws IOException {
		Job job = Job.getInstance(this.conf, this.name);
		return job;
	}

	public void rmr(String outUrl) throws IOException, URISyntaxException {
		FileSystem fileSystem = FileSystem.get(new URI(outUrl), this.conf);
		if (fileSystem.exists(new Path(outUrl))) {
			fileSystem.delete(new Path(outUrl), true);
			System.out.println("outUrl " + outUrl);
		}
	}
}