import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		AdvertisementDAO advertisementDAO = new AdvertisementDAO();
		System.out.println("Enter no. of advertisements done :");
		int n = Integer.parseInt(br.readLine());
		String[] input = new String[n];
		for (int i = 0; i < input.length; i++) {
			input[i] = br.readLine();
		}
		for (int i = 0; i < input.length; i++) {
			Advertisement advertisement = new Advertisement();
			String[] strArray = input[i].split(",");
			advertisement.setAdvertisementMedia(strArray[0]);
			advertisement.setAmountSpent(Double.parseDouble(strArray[1]));
			advertisement.setNoOfAudienceAttracted(Integer.parseInt(strArray[2]));
			advertisementDAO.insert(advertisement);
		}
		System.out.println("Advertisement details");
		System.out.printf("%-5s %-20s %-15s %s\n", "Id", "Advertisement media", "Amount spent",
				"No Of audience attracted");
		List<Advertisement> advertisementList = advertisementDAO.list();
		for (Advertisement advertisement : advertisementList) {
			System.out.printf("%-5s %-20s %-15s %s\n", advertisement.getId(), advertisement.getAdvertisementMedia(),
					advertisement.getAmountSpent(), advertisement.getNoOfAudienceAttracted());
		}
		System.out.println("Enter advertisement id :");
		Advertisement findAdvertisement = advertisementDAO.find(Integer.parseInt(br.readLine()));
		if (null == findAdvertisement) {
			System.out.println("Advertisement not found!");
		} else {
			System.out.println("Enter no of new users attracted :");
			int noOfNewUsers = Integer.parseInt(br.readLine());
			findAdvertisement.setNoOfAudienceAttracted(findAdvertisement.getNoOfAudienceAttracted() + noOfNewUsers);
			advertisementDAO.update(findAdvertisement);
			System.out.println("Advertisement details");
			System.out.printf("%-5s %-20s %-15s %s\n", "Id", "Advertisement media", "Amount spent",
					"No Of audience attracted");
			advertisementList = advertisementDAO.list();
			for (Advertisement advertisement : advertisementList) {
				System.out.printf("%-5s %-20s %-15s %s\n", advertisement.getId(), advertisement.getAdvertisementMedia(),
						advertisement.getAmountSpent(), advertisement.getNoOfAudienceAttracted());
			}
		}
	}
}
