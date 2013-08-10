package mytestmod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class MTMPacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if(packet.channel.equals("MyTestMod")){
			handlePacket(packet);
		}

		
	}

	public void handlePacket(Packet250CustomPayload packet){
		DataInputStream inputStream = DataInputStream (new ByteArrayInputStream(packet.data));
	
		int randomInt1;
		int randomInt2;
		
		try{
			randomInt1 = inputStream.readInt();
			randomInt2 = inputStream.readInt();
		}
		
		catch(IOException e){
			e.printStackTrace();
			return;
		}
		System.out.println(randomInt1 + "" + randomInt2);
	}
	

	private DataInputStream DataInputStream(
			ByteArrayInputStream byteArrayInputStream) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
