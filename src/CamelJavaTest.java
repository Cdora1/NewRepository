import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelJavaTest {

	public static void main(String[] args) {

		CamelContext context = new DefaultCamelContext();
		
		//gifOrderPickPriceQueue=maasMSGProducer:queue:QL.WMT.WW.EIC.OM.UFO.BS.IN.1
		try {
			context.addComponent("activemq", ActiveMQComponent.activeMQComponent("maasMSGProducer:queue:QL.WMT.WW.EIC.OM.UFO.BS.IN.1"));
			try {
				context.addRoutes(new RouteBuilder() {
					@Override
					public void configure() throws Exception {
						from("activemq:queue:test.queue").to("stream:out");
					}
				});

				ProducerTemplate template = context.createProducerTemplate();
				context.start();
				template.sendBody("activemq:test.queue", "Hello World");
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			try {
				context.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
