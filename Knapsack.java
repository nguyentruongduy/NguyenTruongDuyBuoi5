public class Knapsack {

    public static void main(String[] args) {
        int[] sizes = {3, 4, 7, 8, 9};
        int[] values = {4, 5, 10, 11, 13};
        int M = 10;  // Giả sử sức chứa tối đa của balo

        int[] cost = new int[M + 1];
        int[] best = new int[M + 1];

        // Khởi tạo mảng cost
        for (int i = 0; i <= M; i++) {
            cost[i] = 0;
            best[i] = -1;  // Sử dụng -1 để thể hiện rằng chưa có đồ vật nào được chọn
        }

        // Quy hoạch động
        for (int j = 0; j < sizes.length; j++) {
            for (int i = M; i >= 1; i--) {
                if (i >= sizes[j]) {
                    if (cost[i] < cost[i - sizes[j]] + values[j]) {
                        cost[i] = cost[i - sizes[j]] + values[j];
                        best[i] = j;
                    }
                }
            }
        }

        // In ra kết quả
        System.out.println("Gia tri lon nhat co the dat duoc la: " + cost[M]);

        // In ra các đồ vật được chọn
        int w = M;
        System.out.println("Cac do vat duoc chon:");
        while (w > 0 && best[w] != -1) {
            int j = best[w];
            System.out.println("Do vat: " + (j + 1) + " (Kich Thuoc: " + sizes[j] + ", Gia Tri: " + values[j] + ")");
            w -= sizes[j];
        }
    }
}
