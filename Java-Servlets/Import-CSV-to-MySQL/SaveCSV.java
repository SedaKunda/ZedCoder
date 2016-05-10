import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/SaveCSV")
public class SaveCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SaveCSV() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory(); // Create a factory for disk-based file items
        factory.setSizeThreshold(1024 * 1024 * 50);  // Sets the size threshold 
        factory.setRepository(new File(System.getProperty("java.io.tmpdir"))); // Sets the directory used to temporarily store files that are larger than the configured size threshold.
        ServletFileUpload upload = new ServletFileUpload(factory); // Create a new file upload handler
        try {
            List<FileItem> items = upload.parseRequest(request); // Parse the request
            Iterator<FileItem> iter = items.iterator();
            List<String> q= new ArrayList<String>();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();		               
                if (!item.isFormField()) {		                	
                    String fileName = new File(item.getName()).getName(); 		              
                    String filePath = "C:/Users/Seda/workspace/Wordpress" + File.separator + fileName; // TODO: change file path to your desired path
                    File uploadedFile = new File(filePath);
                    item.write(uploadedFile);	// saves the file to upload directory	                   
                    q.add(fileName);                 
                	}		               
            }		         
        }
        catch (Exception e) {	// catch any exceptions	        	
        }		        
        RequestDispatcher rd=request.getRequestDispatcher("/ImportCSVtoDB"); // go to importing servlet after save is completed
 		    rd.include(request,response);    
	}

}
