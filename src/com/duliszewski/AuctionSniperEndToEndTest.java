package com.duliszewski;
import org.junit.After;
import org.junit.jupiter.api.Test;

public class AuctionSniperEndToEndTest {
	private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
	private final ApplicationRunner application = new ApplicationRunner();
	
	@Test public void sniperJoinsAuctionUntillAuctionCloses() throws Exception{
		auction.startSellingItem();
		application.startBiddingIn(auction);
		auction.hasReceivedJoinRequestFromSniper();
		auction.announceClosed();
		application.showSniperHasLostAuction();
	}
	
	//Additional Cleanup
	@After public void stopAuction() {
		auction.stop();
	}
	@After public void stopApplication() {
		application.stop();
	}
	
}
