import java.util.ArrayList;
import java.util.Random;

public class Puzzle{

    public ArrayList<Integer> getTenRolls(){
        Random randomMachine = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            arr.add(randomMachine.nextInt(20)+1);
        }
        return arr;
    }

    public String getRandomLetter(){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        Random randomMachine = new Random();
        return letters[randomMachine.nextInt(26)];
    }

    public String generatePassword(){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String password = "";
        
        for(int i = 0; i < 8; i++){
            password += this.getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int size){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        ArrayList<String> passwords = new ArrayList<String>();
        
        for(int i = 0; i < size; i++){
            System.out.println(i);
            String password = "";
            for(int j = 0; j < 8; j++){
                password += this.getRandomLetter();
            }
            passwords.add(password);
        }
        return passwords;
    }

    public ArrayList<Integer> shuffleArray(ArrayList<Integer> arr1){

        Random randomMachine = new Random();
        int numOfMoves = randomMachine.nextInt(arr1.size());

        for(int i = 0; i < numOfMoves; i++){
            int indexGet = randomMachine.nextInt(arr1.size());
            int indexSet = randomMachine.nextInt(arr1.size());
            int removeElement = arr1.get(indexSet);
            arr1.set(indexSet, arr1.get(indexGet));
            arr1.set(indexGet, removeElement);
        }

        return arr1;
    }
}