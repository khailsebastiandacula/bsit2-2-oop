   public static void main(String[] args) {
        PostManager manager = new PostManager();

        String postTitle = "Java Programming Tips";
        int engagementScore = manager.calculateEngagement(150, 75, 25);
        String category = manager.getCategoryRating(engagementScore);

        System.out.println("=== Post Stats (No Category) ===");
        manager.displayPostStats(postTitle, engagementScore);

        System.out.println("\n=== Post Stats (With Category) ===");
        manager.displayPostStats(postTitle, engagementScore, category);

        String[] hashtags = {"#java", "#coding", "#programming", "#java", "#tips"};
        ArrayList<String> uniqueHashtags = manager.manageHashtags(hashtags);
        System.out.println("\n=== Unique Hashtags ===");
        System.out.println(uniqueHashtags);

        HashSet<String> uniqueAuthors = manager.getUniqueAuthors("Alice", "Bob", "Alice", "Charlie", "Bob");
        System.out.println("\n=== Unique Authors ===");
        System.out.println(uniqueAuthors);

        ArrayList<String> posts = new ArrayList<>();
        posts.add("Java Programming Tips");
        posts.add("Fun with Python");
        posts.add("Web Dev 101");

        HashMap<String, Integer> postEngagement = new HashMap<>();
        postEngagement.put("Java Programming Tips", engagementScore);
        postEngagement.put("Fun with Python", 800);
        postEngagement.put("Web Dev 101", 45);

        LinkedList<String> trendingPosts = manager.findTrendingPosts(posts, postEngagement);
        System.out.println("\n=== Trending Posts (Engagement > 500) ===");
        System.out.println(trendingPosts);
    }
}
