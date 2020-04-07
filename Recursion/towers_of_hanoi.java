public class towers_of_hanoi {
	public static void main(String[] args) {
		hanoi();
	}

	public static void hanoi() {
		int disks = 4;
		int src = 1;
		int dst = 2;
		int tmp = 3;
		moveTower(disks, src, dst, tmp);
	}

	private static void moveOneDisk(int src, int dst) {
		System.out.printf("Move one disk from %d to %d\n", src, dst);
	}

	private static void moveTower(int disks, int src, int dst, int tmp) {
		if (disks == 1)
			moveOneDisk(src, dst);
		else {
			moveTower(disks - 1, src, tmp, dst); // move n-1 disks to tmp
			moveOneDisk(src, dst); // move one disk (base case)
			moveTower(disks - 1, tmp, dst, src); // bring the disks back above the newly moved larger disk
		}
	}

}