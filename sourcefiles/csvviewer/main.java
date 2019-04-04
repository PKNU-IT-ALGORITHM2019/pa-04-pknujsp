package csvviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class main
{
	static public ArrayList<database> values = null;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{

		while (true)
		{
			String input = scan.nextLine();
			control_input(input);
		}

	}

	private static String ConvertTIME(long value)
	{
		String converted = "";
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
		converted = dateformat.format(value);
		return converted;
	}

	private static void control_input(String in)
	{
		String[] for_separation = in.split(" ");

		if (for_separation.length < 2)
		{
			if (for_separation[0].equals("exit"))
			{
				scan.close();
				System.exit(0);
			} else if (for_separation[0].equals("print"))
			{
				print_data();
				return;
			} else
			{
				System.out.println("입력 오류");
				return;
			}
		}
		String method = for_separation[0];
		String value = for_separation[1];

		switch (method)
		{
		case "read":
			read_csv(value);
			break;
		case "sort":
			Sort(value);
			break;
		}
	}

	private static void read_csv(String value) // read
	{
		read_data readdata = new read_data();
		readdata.ReadFile(value);
		values = readdata.get_list();
	}

	private static void Sort(String type)
	{
		switch (type)
		{
		case "-t":
			Collections.sort(values, new Comparator<database>()
			{
				@Override
				public int compare(database a, database b)
				{
					if (a.get_time() > b.get_time())
						return 1;
					else if (a.get_time() == b.get_time())
						return 0;
					else
						return -1;
				}
			});
			System.out.println("completed");
			break;
		case "-ip":
			Collections.sort(values, new Comparator<database>()
			{
				@Override
				public int compare(database a, database b)
				{
					int ret = a.get_ip().compareTo(b.get_ip());
					if (ret == 0)
					{
						ret = (String.valueOf(a.get_time()).compareTo(String.valueOf(b.get_time())));
					}
					return ret;
				}
			});
			System.out.println("completed");
			break;
		}

	}

	private static void print_data()
	{
		for (int i = 0; i < values.size(); i++)
		{
			System.out.println("TIME : " + ConvertTIME(values.get(i).get_time()));
			System.out.println("IP : " + values.get(i).get_ip());
			System.out.println("URL : " + values.get(i).get_url());
			System.out.println("STATUS : " + values.get(i).get_status());
			System.out.println();
		}
	}

}
