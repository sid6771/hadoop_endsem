import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class IndiaDriver 
{
	public static void main(String[] args) throws IOException,ClassNotFoundException, InterruptedException 
	{
		Configuration conf = new Configuration();
		Job job = new Job(conf, "India");  
		job.setJarByClass(IndiaDriver.class);
		job.setMapperClass(IndiaMapper.class);
		job.setReducerClass(IndiaReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
