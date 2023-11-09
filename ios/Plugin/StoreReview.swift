import Foundation
import StoreKit

@objc public class StoreReview: NSObject {
    @objc public func navigateToAppStore(_ appId: String, completionHandler: @escaping (_: Bool) -> Void) {
        guard let writeReviewURL = URL(string: "https://itunes.apple.com/app/id" + appId + "?action=write-review")
        else {
            print("[StoreReview] — Invalid app id")

            return completionHandler(false)
        }
        DispatchQueue.main.async {
            UIApplication.shared.open(writeReviewURL, options: [:], completionHandler: completionHandler)
        }
    }

    @objc public func promtForRating(_ completionHandler: @escaping () -> Void) {
        DispatchQueue.main.async {
            SKStoreReviewController.requestReview()
            completionHandler()
        }
    }
}
