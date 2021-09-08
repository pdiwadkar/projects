package client.test;

import java.io.IOException;
import test.serve.ServiceTest;

public class ClientModuleTest {

	public static void main(String[] args) throws Exception, IOException  {
		// TODO Auto-generated method stub
		
		String Source = "D:\\Work\\Code\\Accion\\Report\\TruckSales-2020.xlsx";
		String Dest = "D:\\Work\\Code\\Accion\\Report\\TruckStats-2020.xlsx";
		ServiceTest.writeClientData(Source,Dest);
	}

}