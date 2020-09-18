package discordbot.bot;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
//    	final String discord_token = "756366459952824321";
    	final String discord_token = "NzU2MzY2NDU5OTUyODI0MzIx.X2QzKA.AVLjMNlRZorHiS3aJLAPc7lvAYU";
    	final DiscordClient discord_client = DiscordClient.create(discord_token);
    	final GatewayDiscordClient gateway = discord_client.login().block();
    	
    	
    	gateway.on(MessageCreateEvent.class).subscribe(event -> {
    		final Message message = event.getMessage();
    		System.out.println(message.getContent());
    		System.out.println(message.getAuthor());
    		System.out.println(message.getUserData().avatar());
    		System.out.println(message.getUserData().email());
    		
    		message.delete().block();
    	});
    	
    	gateway.onDisconnect().block();
    }
}
