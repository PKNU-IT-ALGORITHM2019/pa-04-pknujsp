package csvviewer;



public class database
{
	private String ip;
	private long time;
	private String url;
	private String status;

	protected database(String a, long b, String c, String d)
	{
		this.ip = a;
		this.time = b;
		this.url = c;
		this.status = d;
	}

	protected String get_ip()
	{
		return ip;
	}

	protected long get_time()
	{
		return time;
	}

	protected String get_url()
	{
		return url;
	}

	protected String get_status()
	{
		return status;
	}



}

