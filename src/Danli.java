public class Danli {
    private static Danli danli;

    private Danli(){

    }
    public static Danli getDanli()
    {
        synchronized (Danli.class)
        {
            if(danli==null)
                danli=new Danli();
            return danli;
        }
    }
}
