package player;

public class GsonPlayer {
    public String name;

    public short atk;
    public float hp;
    public float sp;
    public Core core;
    public Effect[] eff;
    public Effect[] mod;

    class Core{
        public String name;
        public Modifiers[] mod;
    }
    class Effect{
        public String name;
        public String time;
        public Modifiers[] mod;
    }
    class Modifiers{
        public byte obj;
        public byte opr;
        public float am;
    }
}