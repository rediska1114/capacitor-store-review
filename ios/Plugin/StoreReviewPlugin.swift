import Capacitor
import Foundation

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(StoreReviewPlugin)
public class StoreReviewPlugin: CAPPlugin {
    private let implementation = StoreReview()

    private var appId: String = ""

    @objc override public func load() {
        super.load()

        appId = getConfigValue("appId") as! String
    }

    @objc func navigateToAppStore(_ call: CAPPluginCall) {
        implementation.navigateToAppStore(appId) { res in
            call.resolve(["value": res])
        }
    }

    @objc func promtForRating(_ call: CAPPluginCall) {
        implementation.promtForRating {
            call.resolve()
        }
    }
}
