public class Principale {
    private CLinput cli;
    private Calendario calendario;
    Principale(){
        cli = new CLinput();
    }
    public static void main(String[] args){
        Principale p;
        p = new Principale();
        p.data();
    }
    public void data(){
        try{
            int g = cli.readInt("Inserire il giorno: ");
            int m = cli.readInt("Inserire il mese: ");
            int a = cli.readInt("Inserire l'anno: ");
            calendario = new Calendario(g, m, a);
            // System.out.println("Data memorizzata correttamente");
            // System.out.println(calendario.sommaGiorni(cli.readInt("Inserire il numero di giorni da sommare: ")));
            int g1 = cli.readInt("Inserire il giorno: ");
            int m1 = cli.readInt("Inserire il mese: ");
            int a1 = cli.readInt("Inserire l'anno: ");
            System.out.println(calendario.differenzaDate(g1, m1, a1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            data();
        }
    }
}