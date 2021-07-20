import java.io.File;
import java.util.logging.Logger;

public class main {

    private final static Logger log = Logger.getGlobal();

    public static void main(String[] args){
        String path = "C:\\Users\\Naka\\AppData\\Local\\Temp\\"; //temp 폴더 경로 지정
        deleteTemp(path); // 경로지정
    }

    public static void deleteTemp(String path){
        File folder = new File(path);
        try {
            if(folder.exists()) {
                File[] folder_list = folder.listFiles(); //폴더 리스트 가져오기
                for(int i = 0; i < folder_list.length; i++) {
                    if (folder_list[i].isFile()) {
                        folder_list[i].delete();
                        log.info(folder.getName() + "파일이 삭제 되었습니다.");
                    } else {
                        deleteTemp(folder_list[i].getPath());
                        log.info("파일이 삭제 되었습니다.");
                    }
                    folder_list[i].delete();
                }
                folder.delete();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
