package abstractclass;
import java.util.*;
import java.io.IOException;
public class abstractclass1 {
	abstract class employee{
		String Name;
		String ID;
		float Salary;
		
		public employee(String name, String iD, float Salary) {
			this.Name = name;
			this.ID = iD;
			this.Salary = Salary;
		}
		public employee() {
			Name =" ";
			ID = " ";
			Salary = 0;
		}
		public abstract float calSalary();
		 
		public void input() {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Name");
			Name = sc.nextLine();
			System.out.print("Enter ID");
			ID = sc.nextLine();
			System.out.print("Enter Salary");
			Salary = sc.nextFloat();
		}
		public void output() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Name: "+this.Name);
			System.out.println("ID:  "+this.ID);
			System.out.println("Salary: "+this.Salary);
		}
		public float calSalary1() {
			return Salary;
		}
	}
	class Regularemployee extends employee	{
		public float SalaryGrading;
		public float BenefitGrading;
		
		public Regularemployee() {
			 SalaryGrading = 0;
			 BenefitGrading = 0;
		}
		public float calSalary() {
			return Salary = 1000000 *(1 + SalaryGrading + BenefitGrading); 
		}
		public void input() {
			super.input();
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter SalaryGrading: ");
			SalaryGrading = sc.nextFloat();
			System.out.print("Enter BenefitGrading: ");
			BenefitGrading = sc.nextFloat();
		}
		
		
	}
	class ContractStaff extends employee {
		public float wage;
		public float worday;
		public float excesshourGrading;
		
		public ContractStaff() {
			wage = 0;
			worday = 0;
			excesshourGrading = 0;
		}
		public void input() {
			super.input();
			Scanner sc =  new Scanner(System.in);
			System.out.print("Enter wage: ");
			wage = sc.nextFloat();
			System.out.print("Enter worday: ");
			worday = sc.nextFloat();
			System.out.print("Enter excesshourGrading");
			excesshourGrading = sc.nextFloat();
		}
		public float calSalary() {
			return Salary = wage* worday* (1 + excesshourGrading);
			
		}
	}
	class employlist{
		employee emplist[] = new employee[100];
		int n = 0;
		char chon, loai;
		
		public void inputemployee() throws IOException{
			do {
				System.out.println("bien che hay hop dong (h/b):");
				loai = (char)System.in.read();
				if(loai == 'h' || loai == 'B') {
					emplist[n] = new ContractStaff();
				}else {
					emplist[n] = new Regularemployee();
				}
					System.in.skip(loai);
					emplist[n++].input();
					System.out.println("Tiep tuc / (C/K)");
					chon = (char)System.in.read();
					System.in.skip(chon);
					if((n == 100) || (chon == 'k') || (chon == 'k')){
						break;
					}
			}while(true);
		}
		public void outputemployee() {
			for(int i = 0; i < n; i++) {
				System.out.println("ID"+emplist[i].ID);
				System.out.println("Salary"+emplist[i].Salary);
				emplist[i].output();
			}
		}
		public void sort() {
			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					if(emplist[i].calSalary() > emplist[j].calSalary()) {
						employee tmp = emplist[i];
						emplist[i] = emplist[j];
						emplist[j] = tmp;
					}
				}
			}
			System.out.println(" ===== employee is SOrt ==== ");
			for(int i = 0; i < n; i++) {
				emplist[i].output();
			}
		}
		public float sumOfSalary() {
			float sum = 0;
			for(int i = 0; i < n; i++) {
				sum += emplist[i].calSalary();
			}
			return sum;
		}
		public void MaxSalary() {
			if(n == 0) {
				System.out.println("/Danh sach rong. ");
				return;
			}
			int MaxIndex = 0;
			for(int i = 1; i < n; i++) {
				if(emplist[i].calSalary() > emplist[MaxIndex].calSalary()) {
					MaxIndex = i;
				}
			}
			System.out.println("Nhan vien co luong cao nhat");
			emplist[MaxIndex].output();
			System.out.println("wage employee: "+emplist[MaxIndex].calSalary());
		}
	}
	public static void main(String[] args) throws IOException {
		abstractclass1 program = new abstractclass1();
		employlist list = program.new employlist();

        list.inputemployee();
        list.outputemployee();
        list.sort();
        System.out.println("Total Salary: " + list.sumOfSalary());
        list.MaxSalary();

	}

	}

