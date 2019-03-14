import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
public class GenerateMessageFor742 {

	public static void main(String[] args){
		GenerateMessageFor742 demo = new GenerateMessageFor742();
		ArrayList<String> insertList = new ArrayList<String>();
		ArrayList<String> delteList =new ArrayList<String>();
		//insertList.add("1-MESSAGE");
		//insertList.add("3-MESSAGE");
		//delteList.add("11-MESSAGE");
		
		delteList.add("19-MESSAGE");
		System.out.println(StringUtils.join(delteList,";"));
		//System.out.println(demo.listToString(delteList,";"));
	}
	
	
	
	public String listToString(List list, String separator) {  
		StringBuilder sb = new StringBuilder();  
		for (int i = 0; i < list.size(); i++) {  
		    sb.append(list.get(i)).append(separator);  
		}
		if(sb.length()>0)
		{
			return sb.toString().substring(0,sb.toString().length()-1);
		}
		else{ 
		return "";
		}
		   
	}  
}
