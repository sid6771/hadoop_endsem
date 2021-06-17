import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class IndiaReducer extends Reducer<Text, IntWritable, Text, IntWritable> 
{
	
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context)	throws IOException, InterruptedException
	{
		int y = 0;
		for (IntWritable x : values) 
		{
			y++;
		}
		context.write(key, new IntWritable(y));
	}
}