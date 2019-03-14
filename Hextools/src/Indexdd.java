
public class Indexdd {
	
	public static void main(String args[]){
		String machineID = "2097-02-MV141 - 1";
		String machineID1 = "2097-02-MV141- 1";
		String machineID2 = "2097-02-MV141 -1";
		Indexdd test = new Indexdd();
		System.out.println(test.getMachineNum(machineID)+"  "+test.getMachineNum(machineID).length());
		System.out.println(test.getMachineNumDemo(machineID1)+"  "+test.getMachineNumDemo(machineID1).length());
		System.out.println(test.getSequence(machineID)+"    "+test.getSequence(machineID).length());
		System.out.println(test.getSequenceDemo(machineID1)+"    "+test.getSequenceDemo(machineID1).length());
	}
	
	public String getMachineNum(String machineID){ 
		//System.out.println("machineID       "+machineID);
		if(machineID == null || machineID.indexOf("-") < 0){
			return "";
		}else{
			return machineID.substring(machineID.indexOf("-") + 1, machineID.indexOf(" - "));
		}
		
	}
	public String getMachineNumDemo(String machineID){ 
		//System.out.println("machineID       "+machineID);
		if(machineID == null || machineID.indexOf("-") < 0){
			return "";
		}else if(machineID.indexOf(" - ")<0){
			if(machineID.indexOf("- ")>0)
		    return machineID.substring(machineID.indexOf("-") + 1, machineID.indexOf("- "));
		
            if(machineID.indexOf(" -")>0)
			
			return machineID.substring(machineID.indexOf("-") + 1, machineID.indexOf(" -"));
		
		}
		return machineID.substring(machineID.indexOf("-") + 1, machineID.indexOf(" - "));
		
		
	}
	public String getSequence(String hardware){
		//System.out.println("hardware       "+hardware);
		if(hardware == null || hardware.indexOf(" - ") < 0){
			return "";
		}else{
			return hardware.substring(hardware.indexOf(" - ") +3);
		}
		
	}
	public String getSequenceDemo(String hardware){
		//System.out.println("hardware       "+hardware);
		if(hardware == null || (hardware.indexOf(" - ") < 0&&hardware.indexOf("- ")<0&&hardware.indexOf(" -")<0)){
			return "";
		}else{
			if(hardware.indexOf(" - ") < 0){
				if(hardware.indexOf(" -") > 0)
				{
					return hardware.substring(hardware.indexOf(" -") +2);
				}
				if(hardware.indexOf("- ") > 0){
					return hardware.substring(hardware.indexOf("- ") +2);
				}
			}
			return hardware.substring(hardware.indexOf(" - ") +3);
		}
		
	}

}
