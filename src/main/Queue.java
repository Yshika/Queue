package main;

import java.util.Scanner;

public class Queue {
    private static class Node{
        private int data;
        private Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private int size=0;
    private Node front=null;
    private Node rear=null;

    public static void main(String[] args) {
        Queue queue=new Queue();
        System.out.println(queue);
        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        for (int i = 0; i < n; i++) {
            queue.enqueue(s.nextInt());
        }
        System.out.println(queue);
        System.out.println(queue.search(s.nextInt()));
        queue.dequeue();
        System.out.println(queue);
        s.close();
    }

    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        result.append("[");
        Node temp=this.front;
        while(temp!=null){
            result.append(temp.getData());
            if(temp.getNext()!=null){
                result.append(" -- ");
            }
            temp=temp.getNext();
        }
        result.append("]");
        return result.toString();
    }
    public void enqueue(int data){
        Node node=new Node(data,null);
        if(this.front==null && this.rear==null){
            this.front=this.rear=node;
        }
        this.rear.setNext(node);
        this.rear=node;
        this.size++;
    }
    public int dequeue(){
        int resp=-1;
        if(this.front!=null){
            resp=this.front.getData();
            this.front=this.front.getNext();
            this.size--;
        }

        return resp;
    }
    public boolean search(int data){
        Node node=this.front;
        while(node!=null){
            if(data==node.getData()) {
                return true;
            }
            node=node.next;
        }
        return false;
    }
}
