import java.util.ArrayList;

public class node {
    private node yes,no;
    private ArrayList<String> data;
    private ArrayList<Boolean> combo = new ArrayList();
    private String msg;
    public node(){}
    public node(ArrayList<Boolean> combo,Boolean me) {
        this.combo = combo;
        this.combo.add(me);
        if(this.combo.size() == 4 ){
            if(this.combo.get(0) == false || (this.combo.get(1) == false && this.combo.get(2) == false) || (this.combo.get(1) == false && this.combo.get(3) == false)){
                msg = "Warning!";
            }
            else{
                msg = "Passable";
            }
        }
        else{
            msg = "not 4 booleans!: ";
        }
    }
    /*
    points is a list of the criterias in order: hand ins, attend lectures, read textbook & make exercises
    as this is the most optimal way to do it
    */
    public void putStudent(ArrayList<Boolean> points, String student){
        if(points.size() == 0){
            if(data == null){
                data = new ArrayList();
            }
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

    // prints all data from all nodes recursively
    public void print(){
        if(data != null){
            System.out.println(msg+"  :  "+combo+" "+data.toString());
        }
        if( data == null && yes == null){
            System.out.println(msg+"  :  "+combo+" []");
        }
        if(yes != null){
            yes.print();
            no.print();
        }
    }
}