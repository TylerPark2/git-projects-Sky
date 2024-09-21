import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Git {
    public static void main(String[] args) throws IOException {
        initRepo("/Users/skystubbeman/Documents/HTCS_Projects");
        testForGitRepo("/Users/skystubbeman/Documents/HTCS_Projects");
        // deleteGitRepo("/Users/skystubbeman/Documents/HTCS_Projects");
    }

    public static void initRepo(String path) throws IOException {
        File git = new File(path, "git");
        if (!git.exists()){
            git.mkdirs();

            File objects = new File(git, "objects");
            objects.mkdir();

            File index = new File(git, "index");
            index.createNewFile();

        } else{
            System.out.println("This already exists!");
        }
    }

    public static void testForGitRepo(String path){
        File git = new File(path, "git");
        File objects = new File(git, "objects");
        File index = new File (git, "index");

        if (git.exists() && git.isDirectory()){
            System.out.println("git directory exists.");
        }
        else{
            System.out.println("git direcotry doesn't exist.");
        }

        if (objects.exists() && objects.isDirectory()){
            System.out.println("objects directory exists.");
        }else{
            System.out.println("objects directory doesn't exist.");
        }

        if (index.exists() && index.isFile()){
            System.out.println("index file exists.");
        }
        else{
            System.out.println("index file doesn't exist.");
        }
    }

    public static void deleteGitRepo(String path){
        File git = new File(path, "git");
        File objects = new File(git, "objects");
        File index = new File (git, "index");

        if (index.exists()){
            if (index.delete()){
                System.out.println("deleted index");
            }
            else{
                System.out.println("didn't delete");
            }
        }

        if (objects.exists()){
            if (objects.delete()){
                System.out.println("deleted objects");
            }
            else{
                System.out.println("didn't delete");
            }
        }

        if (git.exists()){
            if (git.delete()){
                System.out.println("deleted git");
            }
            else{
                System.out.println("didn't delete");
            }
        }
    }
}