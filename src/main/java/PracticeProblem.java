public class PracticeProblem {

	public static void main(String args[]) {
	String[][] arr = new String[][] {
		{"", "", "", ""},
		{"", "", "", ""},
		{"", "", "", ""},
		{"S", "*", "F", "*"}
	};
	System.out.println(searchMazeMoves(arr));



	}


public static int searchMazeMoves(String[][] arr){
	int row = arr.length-1;
	int col = 0;
	int move = 0;

	move = mazeHelper(arr, row, col, move);

	return move;
}

public static int mazeHelper(String[][] arr, int row, int col, int move){
//base case
if (row == -1){
	return -1;
}
if (col == -1){
	return -1;
}
if (row == arr.length){
	return -1;
}
if (col == arr[row].length){
	return -1;
}


if (arr[row][col].equals("*")){
	return -1;
}
if (arr[row][col].equals("F")){
	return move;
}

String tempSpace = arr[row][col];
arr[row][col] = "*";

move++;

int temp1 = mazeHelper(arr, row, col+1, move);
int temp2 = mazeHelper(arr, row-1, col, move);
int temp3 = mazeHelper(arr, row, col-1, move);
int temp4 = mazeHelper(arr, row+1, col, move);

System.out.println(temp1 + "      1");
System.out.println(temp2 + "      2");
System.out.println(temp3 + "      3");
System.out.println(temp4 + "      4");


if(temp1!=-1){
	if(temp1>temp2&&temp2!=-1){
		temp1=temp2;
		}
}
else{
	temp1 = temp2;
}

if(temp3!=-1){
	if(temp3>temp4&&temp4!=-1){
		temp3=temp4;
		}
}

else{
	temp3 = temp4;
}
System.out.println(temp1 + "      1");
System.out.println(temp2 + "      2");
System.out.println(temp3 + "      3");
System.out.println(temp4 + "      4");
System.out.println("it ran");

if(temp3!=-1){
	if(temp3>temp1&&temp1!=-1){
		temp3=temp1;
		}
}
else{
	temp3 = temp1;
}
move = temp3;
arr[row][col] = tempSpace;
return move;
}
}
