public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean hasDuplicate = false;

        // Nested loops without Collections to find duplicates
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    hasDuplicate = true;
                    break;
                }
            }
        }

        if (!hasDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] batch1 = {101, 102, 103, 102, 105};
        int[] batch2 = {101, 102, 103, 104, 105};

        System.out.println("Batch 1 Check:");
        checkDuplicateSeats(batch1);

        System.out.println("\nBatch 2 Check:");
        checkDuplicateSeats(batch2);
    }
}
