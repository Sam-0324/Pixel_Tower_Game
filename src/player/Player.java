package player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player{
    final String name;
    int Attack;
    int Health;
    int Speed;
    Core Core;
    List<Effect> Effect = new ArrayList<>();
    List<Effect> Modifiers = new ArrayList<>();
    class Core{
        public String Name;
        public List<Modifiers> Mod = new ArrayList<>();
    }
    class Effect extends Core{
        public Enum.Time Time;
    }
    class Modifiers{
        public Enum.Object.Value Value;
        public Enum.Object.Filter Object;
        public byte maxSelect;
        public Enum.Operator Operator;
        public boolean isRandom;
        public int Amount;
    }
    public Player(GsonPlayer GP){
        name = GP.name;
        Attack = GP.atk*100;
        Health = (int)(GP.hp*100);
        Speed = (int)(GP.hp*100);
        Core = Import(GP.core);
        Arrays.stream(GP.eff).forEach(E -> Effect.add(Import(E)));
        Arrays.stream(GP.mod).forEach(E -> Modifiers.add(Import(E)));
        System.out.println(name);
        System.out.println(Health);
        System.out.println(Core.Name);
    }
    public Core Import(GsonPlayer.Core GP){
        Core C = new Core();
        C.Name = GP.name;
        C.Mod = Import(GP.mod);
        return C;
    }
    public Effect Import(GsonPlayer.Effect GP){
        Effect E = new Effect();
        E.Name = GP.name;
        if (GP.time == null) {
            E.Time = Enum.Time.All;
        }else if(GP.time.equals("day")){
            E.Time = Enum.Time.Day;
        }else if(GP.time.equals("night")){
            E.Time = Enum.Time.Night;
        }else E.Time = Enum.Time.All;
        E.Mod = Import(GP.mod);
        return E;
    }
    public List<Modifiers> Import(GsonPlayer.Modifiers[] GP){
        List<Modifiers> M = new ArrayList<>();
        for (GsonPlayer.Modifiers E : GP) M.add(Import(E));
        return M;
    }
    private Modifiers Import(GsonPlayer.Modifiers GP){
        Modifiers M = new Modifiers();
        switch (GP.obj) {
            case 1 -> M.Value = Enum.Object.Value.Attack;
            case 2 -> M.Value = Enum.Object.Value.Speed;
            case 3 -> M.Value = Enum.Object.Value.Whimify;
            default -> M.Value = Enum.Object.Value.Health;
        }
        return M;
    }
}