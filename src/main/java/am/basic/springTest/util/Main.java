package am.basic.springTest.util;

import am.basic.springTest.model.Comment;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

//        Comment comment = new Comment();
//        comment.setName("Example");
//        comment.setDescription("Yuhu");
//        comment.setId(7);
//        comment.setUserId(20);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonResult = objectMapper.writeValueAsString(comment);
//        System.out.println(jsonResult);

//        String content ="{\"id\":7,\"name\":\"Example\",\"description\":\"Yuhu\",\"userId\":20}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        Comment comment = objectMapper.readValue(content, Comment.class);
//        System.out.println(comment);



        Comment comment = new Comment();
        comment.setName("Example");
        comment.setDescription("Yuhu");
        comment.setId(7);
        comment.setUserId(20);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(comment);
        System.out.println(jsonResult);

        XmlMapper xmlMapper = new XmlMapper();
        String xmlResult = xmlMapper.writeValueAsString(comment);
        System.out.println(xmlResult);

    }
}
