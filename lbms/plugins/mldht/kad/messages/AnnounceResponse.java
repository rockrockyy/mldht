package lbms.plugins.mldht.kad.messages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lbms.plugins.mldht.kad.DHT;
import lbms.plugins.mldht.kad.DHTConstants;
import lbms.plugins.mldht.kad.Key;

/**
 * @author Damokles
 *
 */
public class AnnounceResponse extends MessageBase {

	/**
	 * @param mtid
	 * @param id
	 */
	public AnnounceResponse (byte[] mtid) {
		super(mtid, Method.ANNOUNCE_PEER, Type.RSP_MSG);
	}

	/* (non-Javadoc)
	 * @see lbms.plugins.mldht.kad.messages.MessageBase#apply(lbms.plugins.mldht.kad.DHT)
	 */
	@Override
	public void apply (DHT dh_table) {
		dh_table.response(this);
	}
	
	@Override
	public Map<String, Object> getInnerMap() {
		Map<String, Object> inner = new HashMap<String, Object>();
		inner.put("id", id.getHash());

		return inner;
	}

}