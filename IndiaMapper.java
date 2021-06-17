import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class IndiaMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{

	
	public void map(LongWritable key, Text value, Context context)throws java.io.IOException, InterruptedException
	{
		String inputstring = value.toString();
		for (String x : inputstring.split(" ")) {
			if( x.equals("India"))
			{
				context.write(new Text("India"), new IntWritable(1));
				
			}
		}
					
	}
}