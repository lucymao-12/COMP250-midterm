public class Comparables implements Comparable<Comparables>{

        private double toCompare;

        public int compareTo(Comparables c){
            return (int)(this.toCompare - c.toCompare);

        }
        public boolean equals(Object obj){
            return (obj instanceof Comparables && ((Comparables) obj).toCompare == this.toCompare);
        }
}

