package Truco;

import java.io.IOException;
import java.io.InputStream;

public class ArrayInputStream extends InputStream {
	
	public ArrayInputStream(Integer[] inputs)
	{
		this.m_data = inputs;
	}

	@Override
	public int read() throws IOException {
		int d = 0;
		if(this.m_currentIndex < this.m_data.length)
		{
			d = this.m_data[this.m_currentIndex];
			this.m_currentIndex++;
		}
		return d;
	}
	
	private Integer[] m_data;
	private int m_currentIndex = 0;

}
