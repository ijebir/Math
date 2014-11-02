import java.util.ArrayList;
import java.util.Collections;

public class Vector{

	public ArrayList<Double> data = null;
	public int size = 0;

	//Tested
	public Vector(ArrayList<Double> input){
		data = input;
		size = data.size();
	}

	//Tested
	public int getSize(){
		return size;
	}

	//Tested
	public double getElement(int index){
		return data.get(index-1);
	}

	//Tested
	public ArrayList<Double> getAllElements(){
		ArrayList<Double> d = new ArrayList<Double>();
		for(int i=1; i<=size; i++){
			d.add(getElement(i));
		}
		return d;
	}

	//Tested
	public void setElement(int index, double var){
		data.set(index-1, var);
	}

	//Tested
	public void addElement(double var){
		data.add(var);
		size++;
	}

	//Tested
	public void deleteAllData(){
		data.clear();
		size = 0;
	}

	//Tested
	public void removeElement(int index){
		data.remove(index-1);
		size--;
	}

	//Tested
        public String toString(){
                String ret = "";
                for(int i=1; i<=getSize(); i++){
                        if(i == getSize()){
                                ret = ret + getElement(i);
                        }
                        else{
                                ret = ret + getElement(i) + " ";
                        }
                }
                return ret;
        }

	//Tested
        public static Vector addZeros(int many, Vector a){
                for(int i=0; i<many; i++){
                        a.addElement((double) 0);
                }
                return a;
        }

        //Tested        
        public static int maxOfVectors(ArrayList<Vector> in){
                ArrayList<Integer> sizes = new ArrayList<Integer>();
                for(int i=0; i<in.size(); i++){
                        sizes.add(in.get(i).getSize());
                }
                return (Collections.max(sizes));

        }

        //Tested
        public static ArrayList<Vector> fixVectors(ArrayList<Vector> in){
                int max = maxOfVectors(in);
                int toAdd = 0;
                for(int j=0; j<in.size(); j++){
                        if(in.get(j).getSize() != max){
                                toAdd = max - in.get(j).getSize();
                                in.set(j, addZeros(toAdd, in.get(j)));
                        }
                        else{
                        }
                }
                return in;
        }

	//Tested
        public static Vector addVectors(Vector a, Vector b){
                ArrayList<Vector> vecs = new ArrayList<Vector>();
                vecs.add(a);
                vecs.add(b);
                vecs = fixVectors(vecs);
                int max = maxOfVectors(vecs);
                a = vecs.get(0);
                b = vecs.get(1);
                ArrayList<Double> newData = new ArrayList<Double>();
                double sum = 0;
                for(int i=1; i<=max; i++){
                        sum = sum + a.getElement(i);
                        sum = sum + b.getElement(i);
                        newData.add(sum);
                        sum = 0;
                }
                return (new Vector(newData));
        }

	//Tested
	public static Vector substractVectors(Vector a, Vector b){
		ArrayList<Vector> vecs = new ArrayList<Vector>();
                vecs.add(a);
                vecs.add(b);
                vecs = fixVectors(vecs);
                a = vecs.get(0);
                b = multiplyByScalar(-1, vecs.get(1));
		return (addVectors(a, b));
        }

	//Tested
	public static Vector collateVectors(Vector a, Vector b){
                ArrayList<Double> aVals = a.getAllElements();
                ArrayList<Double> bVals = b.getAllElements();
                ArrayList<Double> newData = new ArrayList<Double>();
                for(int i=0; i<aVals.size(); i++){
                        newData.add(aVals.get(i));
                }
                for(int j=0; j<bVals.size(); j++){
                        newData.add(bVals.get(j));
                }
                return (new Vector(newData));
        }
        
        //Tested
        public static Vector multiplyByScalar(double s, Vector a){
                for(int i=1; i<=a.getSize(); i++){
                        a.setElement(i, a.getElement(i)*s);
                }
                return a;
        }

	//Tested
	public static Vector multiplyValues(Vector a, Vector b){
		ArrayList<Vector> vecs = new ArrayList<Vector>();
		vecs.add(a);
		vecs.add(b);
		vecs = fixVectors(vecs);
		a = vecs.get(0);
		b = vecs.get(1);
                ArrayList<Double> aVals = a.getAllElements();
                ArrayList<Double> bVals = b.getAllElements();
                ArrayList<Double> newData = new ArrayList<Double>();
                for(int i=0; i<aVals.size(); i++){
                        newData.add(aVals.get(i) * bVals.get(i));
                }
                return (new Vector(newData));
        }

	//Tested
	public static Vector generateZeroVector(int l){
                ArrayList<Double> newData = new ArrayList<Double>();
                for(int i=0; i<l; i++){
                        newData.add((double) 0);
                }
                return (new Vector(newData));
        }

	//Tested
	public static Vector generateZeroOneVector(int l, int o){
                Vector ret = generateZeroVector(l);
                ret.setElement(o, (double) 1);
                return ret;
        }

	//Tested
	public static double multiplyAndAddFeatures(Vector a, Vector b){
		ArrayList<Vector> vecs = new ArrayList<Vector>();
                vecs.add(a);
                vecs.add(b);
                vecs = fixVectors(vecs);
		int max = maxOfVectors(vecs);
		a = vecs.get(0);
		b = vecs.get(1);
		double sum = 0;
		for(int i=1; i<=max; i++){
			sum = sum + (a.getElement(i) * b.getElement(i));
		}
		return sum;
	}

}
