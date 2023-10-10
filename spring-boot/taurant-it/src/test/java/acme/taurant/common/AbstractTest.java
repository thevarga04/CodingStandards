package acme.taurant.common;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@AutoConfigureMockMvc
public abstract class AbstractTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;



  public ResultActions GET(String location) throws Exception {
    return mockMvc.perform(
        get(location)
          .accept(MediaType.APPLICATION_JSON))
      .andDo(print());
  }


  public ResultActions POST(String location) throws Exception {
    return POST(location, null);
  }

  public ResultActions POST(String location, Object serializable) throws Exception {
    var content = objectMapper.writeValueAsString(serializable);
    return mockMvc.perform(
        post(location)
          .content(content)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andDo(print());
  }

}
