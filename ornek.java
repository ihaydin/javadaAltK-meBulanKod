import java.util.Scanner;
 
public class AltKümeBulma{
	public static void main(String[] args){
    	Scanner iha= new Scanner(System.in);
    	
    	//Değişkenler tanımlandı
    	int diziEleman[];
    	int diziElemanSayisi;
    	//Eleman sayısı kullanıcan girilmesi istendi
        System.out.print("Kümenin eleman sayisini giriniz: ");
        diziElemanSayisi=iha.nextInt();
        
        diziEleman=new int[diziElemanSayisi];
        
        System.out.print("{");
        int i;
        //Kullanıcı tarafından elemanlar girildi
		for (i = 0; i < diziElemanSayisi-1; i++){
			diziEleman[i]=i+1;
			System.out.print(diziEleman[i]+",");
			}
		
		//Kümenin elemanları yazdırıldı
		diziEleman[diziElemanSayisi-1]=diziElemanSayisi;
		System.out.print(diziEleman[i]);
		System.out.println("} kümesinin alt kümeleri");
 
		//Altküme sayısını bulma işlemi tanımlandı
		int altKumeSayisi = (int) Math.pow(2, (diziElemanSayisi));
		//Altkümeler string degere cevrildi
		String diziAltKumesi[] = new String[altKumeSayisi]; 
		
        String altKume=" ";
        //Altkümelerin sıralanması için gereken sayılar
        int sayi = 0;
        int rakamlar = 0;
        
        //
        for (i = 0; i < altKumeSayisi; i++){
            sayi = i;
            altKume = "{";
            rakamlar = 0;
            
            //Altkümeleri bulma işlemi tamamlandı
            for (int j = 0; j < diziElemanSayisi; j++){ 
            	
            	//ALtküme elemanlarını bulan algoritma
            	//Sayının 2'ye modu alınır ve binary sistemde kontrol edilir
               if(sayi%2==1){
                    if(rakamlar==0){
                        altKume += diziEleman[j];
                    }
                    else{
                        altKume += ","+diziEleman[j];
                    }
                    rakamlar++;
                }
               //Sayı 2'den küçük ise kontrol edilmeden döngüden cıkarılır
               if(sayi==1){
               	break;
               }
               //Decimal sayı binary'e cevirme işlemi yapılır 
               if(sayi>=2){ 
               	sayi = sayi/2; 
               }
                 
            }
          
            //Elemanlar baska bir stringte tutulur ve baska diziye aktarılır
            altKume += "}";
            diziAltKumesi[i] = altKume;
            altKume = "{";
        }
        //Alt kümelerin sıralı bir sekilde yazdırılma işlemi
        for(i=1;i<altKumeSayisi;i++){
        	for(int j=1;j<altKumeSayisi-i;j++){
        		 if(diziAltKumesi[j].length() > diziAltKumesi[j+1].length()){
        			 //Altkümeler baska stringte toplandı
        			 String depoAltKume=diziAltKumesi[j+1];
        			 diziAltKumesi[j+1]=diziAltKumesi[j];
        			 diziAltKumesi[j]=depoAltKume; 
        		 }
 
             }
        }
        //Alt kümelerin ekrana yazdırılma işlemi
        for ( i = 0; i < altKumeSayisi; i++){ 
           	if(i==0){
        		System.out.println(i+1 +".<boş küme>"); //Boş küme tanımlandı
        	}
           	//Eleman içeren altkümeler yazdırılma işlemi
        	else{
    			System.out.println(i+1 +"."+diziAltKumesi[i]);
    		}
       
        }
        
    }
}
