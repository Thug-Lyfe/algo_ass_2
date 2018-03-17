import java.util.ArrayList;

public class node {
    private node yes,no;
    private ArrayList<String> data = new ArrayList();
    private ArrayList<Boolean> combo = new ArrayList();
    private String msg;
    public node(){}
    public node(ArrayList<Boolean> combo,Boolean me) {
        this.combo = combo;
        this.combo.add(me);
        if(this.combo.size() == 4 ){
            if(this.combo.get(0) == false || (this.combo.get(1) == false && this.combo.get(2) == false) || this.combo.get(1) == false && this.combo.get(3) == false){
                msg = "Warning!";
            }
            else{
                msg = "Passable";
            }
        }
    }

    public void putStudent(ArrayList<Boolean> points, String student){
        if(points.size() == 0){
            data.add(student);
        }
        else{
            if(yes == null){
                no = new node ((ArrayList<Boolean>) combo.clone(),false);
                yes = new node((ArrayList<Boolean>) combo.clone(),true);
            }
            if(points.remove(0)){
                yes.putStudent(points,student);
            }
            else{
                no.putStudent(points,student);
            }
        }
    }
    public void print(int tree){
        if(tree == 0){
            System.out.println(msg+"  :  "+combo+" "+data.toString());
        }
        else {
            yes.print(tree-1);
            no.print(tree-1);
        }
    }
}