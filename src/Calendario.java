public class Calendario {
    private int g;
    private int m;
    private int a;
    public Calendario(int g, int m, int a) throws Exception {
        setAnno(a);
        setMese(m);
        setGiorno(g, m, a);
    }
    //Controllo anno, deve essere compreso tra 0 e 2021
    public void setAnno(int a) throws Exception {
        if (a < 0 || a > 2021) {
            throw new Exception("numero anno errato");
        } else {
            this.a = a;
        }
    }
    //Controllo mese, deve essere compreso tra 1 e 12
    public void setMese(int m) throws Exception {
        if (m < 1 || m > 12) {
            throw new Exception("numero mese errato");
        } else {
            this.m = m;
        }
    }
    //Controllo che il giorno sia compreso tra 1 e il max di giorni del mese
    public void setGiorno(int g, int m, int a) throws Exception {
        int giorniDentroMese = giorniMese(m, a);

        if (g < 1 || g > giorniDentroMese) {
            throw new Exception("numero giorni errato");
        } else {
            this.g = g;
        }
    }
    //Calcolo in base al mese e all'anno (per febbraio) il numero di giorni del mese
    public int giorniMese(int m, int a) {
        int giorniDentroMese = 0;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            giorniDentroMese = 30;
        } else if (m == 2) {
            if ((a % 4 == 0 && (a % 100 != 0 || a % 400 == 0))) {
                giorniDentroMese = 29;
            } else {
                giorniDentroMese = 28;
            }
        } else {
            giorniDentroMese = 31;
        }
        return giorniDentroMese;
    }
    public int getAnno() {
        return this.a;
    }
    public int getMese() {
        return this.m;
    }
    public int getGiorno() {
        return this.g;
    }
    public String sommaGiorni(int numg) throws Exception {
        int g = this.g;
        int m = this.m;
        int a = this.a;
        if(numg < 0){
            throw new Exception("Il numero è errato");
        }
        else {
            numg += g;
            while (numg != 0) {
                int grim_mese = giorniMese(m, a);
                if (grim_mese >= numg) {
                    g = numg;
                    numg = 0;
                } else {
                    numg -= grim_mese;
                    if (m < 12) {
                        m++;
                    } else {
                        m = 1;
                        a++;
                    }
                }
            }
        }
        return "Nuova data: "+ g +" "+ m + " " + a;
    }
    public String differenzaDate(int g2, int m2, int a2)throws Exception{
        int g1 = this.g;
        int a1 = this.a;
        int m1 = this.m;
        int gfin = 0;
        int mfin = 0;
        int afin = 0;
        setMese(m2);
        setAnno(a2);
        setGiorno(g2, m2, a2);
        //Verifico che la prima data sia maggiore
        if(this.a < a1 || (this.a == a1 && ((this.m < m1)||this.m == m1 && this.g <= g1))){
            int giorni = g1;
            //Calcolo la differenza dei giorni
            while(giorni != 0) {
                //Se g è minore allora tolgo i giorni
                if (g1 >= this.g) {
                    gfin = g1 - this.g;
                    giorni = 0;
                } else {
                    //Se g è maggiore allora tolgo i giorni, riduco il mese e trovo i giorniMese
                    this.g -= giorni;
                    m1--;
                    g1 = giorniMese(a1, m1);
                }
            }
            //Calcolo la differenza dei mesi
            mfin = m1-this.m;
            if(mfin<0) {
                a1--;
                mfin = 12+mfin;
            }
            // differenza anni
            afin = a1-this.a;
        }
        else{
            throw new Exception("La seconda data deve essere più piccola della prima!");
        }
        return "La differenza tra le date è di: "+ gfin+ " giorni, "+ mfin +" mesi e "+ afin + " anni.";
    }
}
