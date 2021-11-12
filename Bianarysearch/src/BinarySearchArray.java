import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

interface BinarySearch{
    int binarySearch(int key);
    void add(int value);
    void remove(int index);
    boolean contains(int value);
    void printElements();
    void initializeArray();
    void sort();

}
class BinarySearchArrayList implements BinarySearch{
    ArrayList<Integer>arrLIst=new ArrayList<>();
    static void testBinarySearchArray(BinarySearch searchObject) {
        Scanner s = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" ");
        searchObject.printElements();
        System.out.println("\nWelcome to the Array List Test.");
        int value = 0;
        try {
            System.out.println("Enter an integer to search (or -1 or <Control> D to quit): ");
            String ss = s.nextLine();
            value = Integer.parseInt(ss);
            do {
                int index;
                if ((index = searchObject.binarySearch(value)) >= 0) {
                    System.out.println("Value " + value + " found." + " Do you want to remove it? y/n? ");
                    String answer = s.nextLine();
                    if (answer.equals("y")) {
                        searchObject.remove(index);
                    }
                }
                else {
                    System.out.println("Value " + value + " not found." + " Do you want to add it? y/n? ");
                    String answer = s.nextLine();
                    if (answer.equals("y")){
                        searchObject.add(value);
                    }
                }
                System.out.println(" ");
                System.out.println(" ");
                searchObject.printElements();
                System.out.println(" ");
                System.out.println("Enter an integer to search (or <Control> D to quit): ");
                ss = s.nextLine();
                value = Integer.parseInt(ss);
            }
            while (!ss.equals("-1"));
        } catch (NoSuchElementException e) {
            System.out.println("Goodbye...");
        }
    }

    @Override
    public int binarySearch(int key) {
        sort();
        return Collections.binarySearch(arrLIst,key);
    }
    @Override
    public void add(int value) {
        arrLIst.add(value);
        sort();
    }

    @Override
    public void remove(int index) {
        arrLIst.remove(index);
    }

    @Override
    public boolean contains(int value) {

        for(int i=0;i<arrLIst.size();i++){

            if (arrLIst.get(i)==value){
                return true;
            }
        }
        return false;
    }

    @Override
    public void printElements() {
        for(int i =0;i<arrLIst.size();i++){
            System.out.print(arrLIst.get(i)+" ");
        }
    }

    @Override
    public void initializeArray() {


        Random rand = ThreadLocalRandom.current();
        int max = 25;int min= 1;
        int added =0;
        while (added<15){
            int num = rand.nextInt((max-min)+1)+min;
            if(!contains(num)){
                add(num);
                added=added+1;
            }
        }
    }
    @Override
    public void sort() {
        Collections.sort(arrLIst);
    }
}

public class BinarySearchArray implements BinarySearch {
    int arr[] = new int[15];

    static void testBinarySearchArray(BinarySearch searchObject) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" ");
        searchObject.printElements();
        System.out.println("\nWelcome to the Array Test.");
        int value = 0;
        try {
            System.out.println("Enter an integer to search (or -1 or <Control> D to quit): ");
            String ss = scanner.nextLine();
            value = Integer.parseInt(ss);
            do {
                int index;
                if ((index = searchObject.binarySearch(value)) >= 0) {
                    System.out.println("Value " + value + " found." + " Do you want to remove it? y/n? ");
                    String answer = scanner.nextLine();
                    if (answer.equals("y")) {
                        searchObject.remove(index);
                    }
                }
            else {
                    System.out.println("Value " + value + " not found." + " Do you want to add it? y/n? ");
                    String answer = scanner.nextLine();
                    if (answer.equals("y")){
                        searchObject.add(value);
                    }
            }
            System.out.println(" ");
            System.out.println(" ");
            searchObject.printElements();
            System.out.println(" ");
            System.out.println("Enter an integer to search (or <Control> D to quit): ");
            ss = scanner.nextLine();
            value = Integer.parseInt(ss);
            }
            while (!ss.equals("-1"));
        } catch (NoSuchElementException e) {
            System.out.println("Goodbye...");
        }
    }

    public static void main(String[]args) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter 1 to test array, enter 2 to test array list: ");
            int x = s.nextInt();
            if (x==1){
                BinarySearchArray bsArr = new BinarySearchArray();
                bsArr.initializeArray();
                bsArr.sort();
                bsArr.printElements();
                BinarySearchArray.testBinarySearchArray(bsArr);
            }
            if (x==2){
                BinarySearchArrayList bsArrList = new BinarySearchArrayList();
                bsArrList.initializeArray();
                bsArrList.sort();
                bsArrList.printElements();
                BinarySearchArrayList.testBinarySearchArray(bsArrList);
            }
    }

    @Override
    public int binarySearch(int key) {
        sort();
        return Arrays.binarySearch(arr,key);
    }

    @Override
    public void add(int value) {
        if(contains(value)){
            return;
        }
        if (!contains(0)){
            System.out.println("no space");
        }
        for(int i=0;i<arr.length-1;i++){
            if (arr[i]==0){
                arr[i]=value;
                break;
            }
        }
        Arrays.sort(arr);
    }

    @Override
    public void remove(int index) {
        for(int i = index; i < arr.length -1; i++){
            arr[i] = arr[i + 1];
        }
        arr[arr.length-1]=0;
        sort();
    }

    @Override
    public boolean contains(int value) {

        for(int i = 0;i<arr.length-1;i++){
            if (arr[i]==value){
                return true;
            }
        }
        return false;
    }

    @Override
    public void printElements() {
        for (int i = 0;i<arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }

    @Override
    public void initializeArray() {

        Random rand = ThreadLocalRandom.current();
        int max = 25;int min= 1;
        int added =0;
        while (added<15){
            int num = rand.nextInt((max-min)+1)+min;
            if(!contains(num)){
                add(num);
                added=added+1;
            }
        }
    }

    @Override
    public void sort() {
        Arrays.sort(arr);
    }
}
