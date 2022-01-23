package player;
public class Enum{
     public enum Time{
        All,
        Day,
        Night
    }
    public enum Operator {
        Plus,
        Multiplied,
        EndPlus
    }
    static class Object{
        public enum Filter{
            Self,
            Enemy,
            All
        }
        public enum Value{
            Health,
            Attack,
            Speed,
            Whimify
        }
    }
}