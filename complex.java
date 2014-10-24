public class complex{

	public double real = 0;
	public double imaginary = 0;
	public double modulus = 0;
	public double argument = 0;

	//Tested
	public complex(double var1, double var2, int a){
		if(a==0){
			real = var1;
			imaginary = var2;
			modulus = Math.sqrt((var1*var1) + (var2*var2));
			argument = Math.atan(var2/var1);
		}
		else if(a==1){
			modulus = var1;
			argument = var2;
			real = var1 * Math.cos(var2);
			imaginary = var1 * Math.sin(var2);
		}
		else{
			modulus = 0;
			argument = 0;
			real = 0;
			imaginary = 0;
		}
	}

	//Tested
	public String toString(){
		String a = "The Real Part is " + real + "\n";
		String b = "The Imaginary Part is " + imaginary + "\n";
		String c = "The Value of The Modulus is " + modulus + "\n";
		String d = "The Value of The Argument is " + argument + "\n";
		String ret = a + b + c + d;
		return ret;
	}

	//Tested
	public double getReal(){
		return real;
	}

	//Tested
	public double getImaginary(){
		return imaginary;
	}

	//Tested
	public void setReal(double second){
		real = second;
		modulus = Math.sqrt((real*real) + (imaginary*imaginary));
		argument = Math.atan(imaginary/real);
	}
	
	//Tested	
	public void setImaginary(double first){
		imaginary = first;
		modulus = Math.sqrt((real*real) + (imaginary*imaginary));
		argument = Math.atan(imaginary/real);
	}

	//Tested
	public double getModulus(){
		return modulus;
	}

	//Tested
	public double getArgument(){
		return argument;
	}

	//Tested
	public void setModulus(double source){
		modulus = source;
		real = modulus * Math.cos(argument);
		imaginary = modulus * Math.sin(argument);
	}

	//Tested
	public void setArgument(double source){
		argument = source;
		real = modulus * Math.cos(argument);
		imaginary = modulus * Math.cos(argument);
	}

	//Tested
	public static complex getConjugate(complex a){
		return new complex(a.getReal(), -1*a.getImaginary(), 0);
	}

	//Tested
	public static complex add(complex a, complex b){
		double c = a.getReal() + b.getReal();
		double d = a.getImaginary() + b.getImaginary();
		return new complex(c,d, 0);
	}
	
	//Tested
	public static complex multiply(complex a, complex b){
		double c = (a.getReal() * b.getReal()) - (a.getImaginary() * b.getImaginary()); 
		double d = (a.getReal() * b.getImaginary()) + (a.getImaginary() * b.getReal());
		return new complex(c,d, 0);
	}

	//Tested
	public static complex divide(complex a, complex b){
		complex c = multiply(a, getConjugate(b));
		complex d = multiply(b, getConjugate(b));
		return new complex(c.getReal()/d.getReal(), c.getImaginary()/d.getReal(), 0);
	}

	//Tested
	public static complex multiplyConstant(complex a, double b){
		double re = a.getReal()*b;
		double im = a.getImaginary()*b;
		return new complex(re, im, 0);
	}

	//Tested	
	public static complex eToTheComplex(complex a){
		double re = Math.exp(a.getReal()) * Math.cos(a.getImaginary());
		double im = Math.exp(a.getReal()) * Math.sin(a.getImaginary());
		return new complex(re, im, 0);
	}
	
	//Tested
	public static complex lnOfComplex(complex a){
		double re = Math.log(a.getModulus());
		double im = a.getArgument();
		return new complex(re, im, 0);
	}

}
