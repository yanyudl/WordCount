import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author: dl
 * @Date: 2024/5/12
 **/
public class WordCount {
    public static void main(String[] args) throws Exception{//接受命令参数 判断是否为2
        if(args.length != 2) {
            System.out.println("参数有误");
            System.exit(1);//直接退出程序
        }

        String character = args[0];
        String EnglishTxt = args[1];

        int count =0;//统计数
        BufferedReader reader = new BufferedReader(new FileReader(EnglishTxt));//通过BufferedReader类的缓存机制，可以在读取文本数据时，提高读取效率
        int ch = 0;//用于接受reader读到的字符的ASCII码
        if(character.equals("-c")){//统计字符
            while((ch = reader.read()) != -1){//读的是对应字符的ASCII码
                count++;
            }

            System.out.println("字符数 =" + count);
        }else if(character.equals("-w")){
            while((ch = reader.read()) != -1){
                if(Character.isWhitespace((char) ch)){//判断是否有空格、换行符、tab键等的空白字符
                    count++;
                } 
            }

            count++;//最后一个单词后没有空白字符，所以要加上1

            System.out.println("单词数 =" + count);
        }
    }
}
