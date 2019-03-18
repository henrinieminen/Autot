package fi.eatech.fleetmanagerws;

public class Car {
	
	private String Merkki;
	private String Malli;
	private String RekNmr;
	private String VuosMal;
	private String KatPvm;
	private String MootTil;
	private String MootTeho;
	
	// constructor 
	   public Car(String a, String b, String c, String d, String e, String f, String g ) { 
	      Merkki = a; 
	      Malli = b; 
	      RekNmr = c;
	      VuosMal = d;
	      KatPvm = e;
	      MootTil = f;
	      MootTeho = g;
	      
	   } 
	   
	   public void setMerkki(String t) { 
		   Merkki = t; 
	   } 
	   
	   public String getMerkki() { 
		   return Merkki; 
	   }
	   
	   public void setMalli(String t) { 
		   Malli = t; 
	   } 
	   
	   public String getMalli() { 
		   return Malli;
	   }
	  
	   public void setRekNmr(String t) { 
		   RekNmr = t; 
	   } 
	   
	   public String getRekNmr() { 
		   return RekNmr;
	   } 
	   
	   public void setVuosMal(String t) { 
		   VuosMal = t; 
	   } 
	   
	   public String getVuosMal() { 
		   return VuosMal; 
	   } 
	   public void setKatPvm(String t) { 
		   KatPvm = t; 
	   } 
	   
	   public String getKatPvm() { 
		   return KatPvm; 
	   }

	   public void setMootTil(String t) { 
		   MootTil = t; 
	   } 
	   
	   public String getMootTil() { 
		   return MootTil; 
	   }
	   
	   public void setMootTeho(String t) { 
		   MootTeho = t; 
	   } 
	   
	   public String getMootTeho() { 
		   return MootTeho; 
	   } 
		   
		   
	

}
