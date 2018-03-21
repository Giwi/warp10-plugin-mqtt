package io.warp10.plugins.mqtt;

import org.fusesource.mqtt.client.Message;

import io.warp10.script.NamedWarpScriptFunction;
import io.warp10.script.WarpScriptException;
import io.warp10.script.WarpScriptStack;
import io.warp10.script.WarpScriptStackFunction;

public class MQTTACK extends NamedWarpScriptFunction implements WarpScriptStackFunction {
  public MQTTACK(String name) {
    super(name);
  }

  @Override
  public Object apply(WarpScriptStack stack) throws WarpScriptException {
    Object top = stack.pop();
    
    if (null != top && !(top instanceof Message)) {
      throw new WarpScriptException(getName() + " operates on an MQTT Message instance.");
    }
    
    if (null != top) {
      ((Message) top).ack();
    }
    
    return stack;
  }
}
