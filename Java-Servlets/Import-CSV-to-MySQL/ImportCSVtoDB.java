import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.opencsv.CSVReader;

@WebServlet("/ImportCSVtoDB")
public class ImportCSVtoDB extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportCSVtoDB() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        String target_file ;  // fileThatYouWantToFilter
        File folderToScan = new File("C:/Users/Seda/workspace/Wordpress"); //  this is the path we are scanning        
        File[] listOfFiles = folderToScan.listFiles();// this is the list of files returned in this folder       
        for (int j = 0; j < listOfFiles.length; j++) { // for each file in the folder
            if (listOfFiles[j].isFile()) {
                target_file = listOfFiles[j].getName();
                if (target_file.equals("blog.csv")) { // look for the file. You can also check if it ends with csv etc.              
			try 
			{
				Database db = new Database(); 
				String loadQuery = "LOAD DATA LOCAL INFILE 'C:/Users/Seda/workspace/Wordpress/blog.csv' INTO TABLE" 
						+ "importcsv FIELDS TERMINATED BY ','LINES TERMINATED BY '\n' (fname, sex) "; //remember to change the path here as well
				Statement stmt = db.dbConn().createStatement();
				stmt.execute(loadQuery);							
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}					
			try (CSVReader reader = new CSVReader(new FileReader("C:/Users/Seda/workspace/Wordpress/" + target_file), ',');)
            {
				Database db = new Database();
				String insertQuery = "Insert into importcsv (fname, sex) values (?,?)";//write your insertion query
				PreparedStatement pstmt = db.dbConn().prepareStatement(insertQuery);
				String[] rowData = null;// create empty array which will hold values from csv
				while((rowData = reader.readNext()) != null)
				{
					int i = 0;
					for (String data : rowData)
						{
						i++; 
							if (i<3) {
								pstmt.setString(i, data);
									if (i == 2) {
										pstmt.addBatch();// add batch
									}
									if (i % 30 == 0)// insert when the batch size is 10
										{
										pstmt.executeBatch(); // execute queries
										}
							}
						}
				}
						
            }
			catch (Exception e)	{
				e.printStackTrace();}
                }
            }
        }
		out.println("success");
	}
}
