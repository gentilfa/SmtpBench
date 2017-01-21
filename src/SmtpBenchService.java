

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import impl.ExeSmtp;
import po.SmtpBenchParam;
import po.StatisticPojo;

@Path("/smtpbench")
public class SmtpBenchService {

	  @POST
	  @Path("/main")
	  @Produces("application/json")
	  public Response execute(SmtpBenchParam param) throws Throwable {
	
		StatisticPojo result = null;
		try {
			result = ExeSmtp.executeBench(param);
		} catch (Throwable e) {
			result = new StatisticPojo();
			result.setMessageError(e.getMessage());
		}
		return Response.status(200).entity(result).build();
	  }
	
}
