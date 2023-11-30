yq = 3
down = {5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
ZY = {-3, -3, -3, -3, -4, -4, -4, -4, -4, -4, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}

yaqiang = false

function OnEvent(event, arg)
    if event == "MOUSE_BUTTON_PRESSED" and arg == yq then
        yaqiang = not yaqiang
    end
    if yaqiang then
        i = 1
        z = 1
        if event == "MOUSE_BUTTON_PRESSED" and arg == 1 then
            Sleep(math.random(105, 115))
            while (IsMouseButtonPressed(1)) do

                MoveMouseRelative(0, down[i])
                i = i + 1
                if i>20 then
                    MoveMouseRelative(ZY[z], 0)
                    z = z + 1
                end
                Sleep(math.random(25, 35))

            end
        end
    end
end