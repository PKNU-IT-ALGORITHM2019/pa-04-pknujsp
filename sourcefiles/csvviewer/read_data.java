package csvviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class read_data
{
	private ArrayList<database> LIST = new ArrayList<database>();

	public void ReadFile(String filename)
	{

		String line = "";
		String token = ",";

		try
		{
			File file = new File(filename);
			BufferedReader br = new BufferedReader(new FileReader(file));

			br.readLine();
			while ((line = br.readLine()) != null)
			{

				String[] temp = line.split(token);

				database db = new database(temp[0], ConvertTIME(delete_paste(temp[1])), temp[2], temp[3]);
				LIST.add(db);
			}

			br.close();
			System.out.println("읽기 완료");

		} catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	private static long ConvertTIME(String value)
	{
		long milli = 0L;
		try
		{
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss", Locale.ENGLISH);
			Date date = dateformat.parse(value);
			milli = date.getTime();
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return milli;

	}

	private String delete_paste(String value)
	{
		return value.substring(1, value.length());

	}

	public ArrayList<database> get_list()
	{
		return LIST;
	}

}
