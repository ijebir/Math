mport java.util.ArrayList;
import java.util.Collections;

public class Matrix{

	public ArrayList<Vector> data = null;
	public int row = 0;
	public int col = 0;

	//Tested
	public Matrix(ArrayList<Vector> input){
		data = Vector.fixVectors(input);
		row = data.size();
		col = data.get(0).getSize();
	}

	//Tested
	public int getRowsDimention(){
		return row;
	}

	//Tested
	public int getColsDimention(){
		return col;
	}

	//Tested
	public void addRow(Vector a){
		data.add(a);
		row++;
	}

	//Tested
	public Vector getRow(int index){
                return data.get(index-1);
        }

	//Tested
	public void setRow(int index, Vector a){
		data.set(index-1, a);
	}

	//Tested
	public ArrayList<Vector> getAllRows(){
		ArrayList<Vector> ret = new ArrayList<Vector>();
		for(int i=1; i<=row; i++){
			ret.add(getRow(i));
		}
		return ret;
	}
        
	//Tested
        public Vector getCol(int index){
                ArrayList<Double> d = new ArrayList<Double>();
                for(int i=0; i<row; i++){
                        d.add(data.get(i).getElement(index));
                }
                return (new Vector(d));
        }

	//Tested
	public ArrayList<Vector> getAllCols(){
		ArrayList<Vector> vecs = new ArrayList<Vector>();
		int max = getColsDimention();
		for(int i=1; i<=max; i++){
			vecs.add(getCol(i));
		}
		return vecs;
	}

	//Tested
	public double getElement(int a, int b){
		return getRow(a).getElement(b);
	}

	//Tested
	public void setElement(int a, int b, double c){
		Vector r = getRow(a);
		r.setElement(b, c);
		setRow(a, r);
	}

	//Tested
	public void multiplyByScalar(double s){
		ArrayList<Vector> vecs = getAllRows();
		int max = getRowsDimention();
		for(int i=1; i<=max; i++){
			setRow(i, Vector.multiplyByScalar(s, vecs.get(i-1)));
		}
	}

	//Tested
	public String toString(){
		String ret = "";
		for(int i=1; i<=getRowsDimention(); i++){
			if(i==getRowsDimention()){
				ret = ret + getRow(i).toString();
			}
			else{
				ret = ret + getRow(i).toString() + "\n";
			}
		}
		return ret;
	}

	//Tested
	public static Matrix addMatricies(Matrix A, Matrix B){

		ArrayList<Vector> aVecs = A.getAllRows();
		ArrayList<Vector> bVecs = B.getAllRows();

		ArrayList<Vector> newVecs = new ArrayList<Vector>();
		int max = aVecs.size();

		for(int i=0; i<max; i++){
			newVecs.add(Vector.addVectors(aVecs.get(i), bVecs.get(i)));
		}
		return (new Matrix(newVecs));
	}

	//Tested
	public static Matrix multiplyMatricies(Matrix A, Matrix B){
	
		ArrayList<Vector> bCols = B.getAllCols();
		ArrayList<Vector> newVecs = new ArrayList<Vector>();

		for(int i=0; i<bColSize; i++){
			newVecs.add(multiplyMatrixVector(A, bCols.get(i)));
		}
		
		Matrix a = new Matrix(newVecs);
		a = Matrix.getTranspose(a);
		return a;
	}

	//Tested
	public static Vector multiplyMatrixVector(Matrix a, Vector b){
		ArrayList<Vector> aRows = a.getAllRows();
		int aRowSize = a.getRowsDimention();
		ArrayList<Double> newData = new ArrayList<Double>();
		for(int i=0; i<aRowSize; i++){
			newData.add(Vector.multiplyAndAddFeatures(aRows.get(i), b));
		}
		return (new Vector(newData));
	}

	//Tested
	public static Matrix genId(int num){
		ArrayList<Vector> newVecs = new ArrayList<Vector>();
		for(int i=1; i<=num; i++){
			newVecs.add(Vector.generateZeroOneVector(num, i));
		}
		return (new Matrix(newVecs));
	}

	//Tested(assumes same dimention)
	public static Matrix collateMatricies(Matrix a, Matrix b){
		ArrayList<Vector> aRows = a.getAllRows();
		ArrayList<Vector> bRows = b.getAllRows();
		ArrayList<Vector> newData = new ArrayList<Vector>();
		for(int i=0; i<aRows.size(); i++){
			newData.add(Vector.collateVectors(aRows.get(i), bRows.get(i)));
		}
		return (new Matrix(newData));
	}

	//Tested
	public static Matrix multiplyRowByScalar(Matrix a, int r, int s){
		Vector b = a.getRow(r);
		b = Vector.multiplyByScalar(s, b);
		a.setRow(r, b);
		return a;
	}

	//Tested
	public static Matrix switchRows(Matrix a, int r1, int r2){
		Vector b = a.getRow(r1);
		Vector c = a.getRow(r2);
		a.setRow(r1, c);
		a.setRow(r2, b);
		return a;
	}

	//Tested
	public static Matrix multiplyRowByRow(Matrix a, int r1, int r2){
		Vector b = a.getRow(r1);
		b = Vector.multiplyValues(b, a.getRow(r2));
		a.setRow(r1, b);
		return a;
	}

	//Tested
	public static Matrix addRows(Matrix a, int r1, int r2){
		Vector b = a.getRow(r1);
		b = Vector.addVectors(b, a.getRow(r2));
		a.setRow(r1, b);
		return a;
	}

	//Not Working
	public static Matrix substractRows(Matrix a, int r1, int r2){
		Vector b = a.getRow(r1);
		b = Vector.substractVectors(b, a.getRow(r2));
		a.setRow(r1, b);
		return a;
	}

	//Tested
	public static Matrix getTranspose(Matrix a){
		ArrayList<Vector> aCols= a.getAllCols();
		return (new Matrix(aCols));
	}


	

}
