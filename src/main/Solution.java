package main;
import java.io.*;
import java.util.*;

public class Solution {
    private static class Node{
        private int data;
        private Node next=null;
        public Node(int data,Node next)
        {
            this.data=data;
            this.next=next;
        }
    }
    private Node front=null;
    private Node rear=null;
    public void enqueue(int data){
        Node temp=new Node(data,front);
        if(front==null){
            front=temp;
            front.next=null;
        }
        else{
            Node t=front;
            while(t.next!=null){
                t=t.next;
            }
            t.next=temp;
            rear=temp;
        }
    }
    public void dequeue(){
        if(rear!=null ||front!=null){
            front=front.next;
        }
    }
    public void print(){
        if(front!=null){
            System.out.println(front.data);
        }
    }
    public static void main(String[] args) {
        Solution sol=new Solution();
        int q,type,x;
        Scanner s=new Scanner(System.in);
        q=s.nextInt();
        while(q>0){
            q--;
            type=s.nextInt();
            if(type==1){
                x=s.nextInt();
                sol.enqueue(x);
            }
            else if(type==2){
                sol.dequeue();
            }
            else{
                sol.print();
            }
        }
    }
}
